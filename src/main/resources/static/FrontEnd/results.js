document.addEventListener('DOMContentLoaded', function () {
    const table = document.getElementById('courseTable');
    const tableBody = table.querySelector('tbody');

    function getQueryParams() {
        const queryParams = new URLSearchParams(window.location.search);
        const params = {};
        queryParams.forEach((value, key) => {
            params[key] = value;
        });
        return params;
    }

    const queryParams = getQueryParams();
    const queryParameters = [];

    if (queryParams.term !== "All") queryParameters.push(`term=${queryParams.term}`);
    if (queryParams.instructor !== "All") queryParameters.push(`instructor=${queryParams.instructor}`);
    if (queryParams.location !== "All") queryParameters.push(`location=${queryParams.location}`);
    if (queryParams.day !== "All") queryParameters.push(`day=${queryParams.day}`);
    const queryString = queryParameters.join('&');


    if (queryString !== "") {
        fetch(`http://localhost:8080/filter?${queryString}`)
            .then(response => response.json())
            .then(filteredCourses => populateCourseTable(filteredCourses))
    }

    function populateCourseTable(courses) {
        tableBody.innerHTML = '';

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
});