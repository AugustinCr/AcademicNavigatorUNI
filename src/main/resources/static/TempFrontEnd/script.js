document.addEventListener('DOMContentLoaded', function() {
    const termFilter = document.getElementById('termFilter');
    const instructorFilter = document.getElementById('instructorFilter');
    const locationFilter = document.getElementById('locationFilter');
    const table = document.getElementById('courseTable');
    const tableBody = table.querySelector('tbody');

    fetch('http://localhost:8080/terms')
        .then(response => response.json())
        .then(terms => populateDropdown(termFilter, terms));

    fetch('http://localhost:8080/instructors')
        .then(response => response.json())
        .then(instructors => populateDropdown(instructorFilter, instructors));

    fetch('http://localhost:8080/locations')
        .then(response => response.json())
        .then(locations => populateDropdown(locationFilter, locations));

    fetch('http://localhost:8080/courses')
        .then(response => response.json())
        .then(courses => populateCourseTable(courses));

    function populateCourseTable(courses) {
        courses.forEach(course => {
            const row = document.createElement('tr');
            row.innerHTML = `
            <td>${course.year}</td>
            <td>${course.term}</td>
            <td>${course.course}</td>
            <td>${course.section}</td>
            <td>${course.instructor}</td>
            <td>${course.enrolled}</td>
            <td>${course.available}</td>
            <td>${course.days}</td>
            <td>${course.time}</td>
            <td>${course.location}</td>
        `;
            tableBody.appendChild(row);
        });
    }

    function populateDropdown(element, option) {
        option.forEach(option => {
            const optionElement = document.createElement('option');
            optionElement.value = option;
            optionElement.textContent = option;
            element.appendChild(optionElement);
        });
    }

    document.getElementById('filterButton').addEventListener('click', function() {
        const selectedTerm = termFilter.value;
        const selectedLocation = locationFilter.value;
        const selectedInstructor = instructorFilter.value;

        fetch(`http://localhost:8080/filter?term=${selectedTerm}&instructor=${selectedInstructor}&location=${selectedLocation}`)
            .then(response => response.json())
            .then(filteredCourses => updateTable(filteredCourses));

        function updateTable(filteredCourses) {
            tableBody.innerHTML = '';

            filteredCourses.forEach(course => {
                const row = document.createElement('tr');
                row.innerHTML = `
                <td>${course.year}</td>
                <td>${course.term}</td>
                <td>${course.course}</td>
                <td>${course.section}</td>
                <td>${course.instructor}</td>
                <td>${course.enrolled}</td>
                <td>${course.available}</td>
                <td>${course.days}</td>
                <td>${course.time}</td>
                <td>${course.location}</td>
            `;
                tableBody.appendChild(row);
            });
        }
    });
});