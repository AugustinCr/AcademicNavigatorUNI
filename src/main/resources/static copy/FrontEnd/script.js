document.addEventListener('DOMContentLoaded', function() {
    const tableBody = document.querySelector('.result-table tbody');
    const searchParams = new URLSearchParams(window.location.search);
    const courseSearch = searchParams.get('course');
    const instructorSearch = searchParams.get('instructor');
    const majorSearch = searchParams.get('major');
    const campusSearch = searchParams.get('campus');

    // Fetch data based on the search parameters
    fetch(`http://localhost:8080/search?course=${courseSearch}&instructor=${instructorSearch}&major=${majorSearch}&campus=${campusSearch}`)
        .then(response => response.json())
        .then(data => updateTable(data));

    // Function to update the table with search results
    function updateTable(searchResults) {
        tableBody.innerHTML = '';

        if (searchResults.length === 0) {
            const noResultsRow = document.createElement('tr');
            noResultsRow.innerHTML = '<td colspan="10">No results found</td>';
            tableBody.appendChild(noResultsRow);
            return;
        }

        // Populate the table with search results
        searchResults.forEach(result => {
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${result.courseName}</td>
                <td>${result.courseId}</td>
                <td>${result.instructor}</td>
                <td>${result.available}</td>
                <td>${result.days}</td>
                <td>${result.time}</td>
                <td>${result.campus}</td>
                <td>${result.section}</td>
                <td>${result.major}</td>
                <td><button class="save-button">Save</button></td>
            `;
            tableBody.appendChild(row);
        });
    }
});



