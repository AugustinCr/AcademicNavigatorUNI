document.addEventListener('DOMContentLoaded', function() {
    const termFilter = document.getElementById('term-search');
    const instructorFilter = document.getElementById('instructor-search');
    const locationFilter = document.getElementById('campus-search');
    const dayFilter = document.getElementById('day-select');

    fetch('http://localhost:8080/terms')
        .then(response => response.json())
        .then(terms => populateDropdown(termFilter, terms));

    fetch('http://localhost:8080/instructors')
        .then(response => response.json())
        .then(instructors => populateDropdown(instructorFilter, instructors));

    fetch('http://localhost:8080/locations')
        .then(response => response.json())
        .then(locations => populateDropdown(locationFilter, locations));

    fetch('http://localhost:8080/days')
        .then(response => response.json())
        .then(days => populateDropdown(dayFilter, days));

    function populateDropdown(element, option) {
        option.forEach(option => {
            const optionElement = document.createElement('option');
            optionElement.value = option;
            optionElement.textContent = option;
            element.appendChild(optionElement);
        });
    }


    document.getElementById('search-button').addEventListener('click', function() {
        const selectedTerm = termFilter.value;
        const selectedInstructor = instructorFilter.value;
        const selectedLocation = locationFilter.value;
        const selectedDay = dayFilter.value;

        const queryParams = new URLSearchParams({
            term: String(selectedTerm),
            instructor: String(selectedInstructor),
            location: String(selectedLocation),
            day: String(selectedDay)
        });

        window.location.href = `search-result.html?${queryParams.toString()}`;
    });
});