document.addEventListener("DOMContentLoaded", function () {

    var searchButton = document.getElementById("search-button");

    
    searchButton.addEventListener("click", function () {
        
        var courseSearchValue = document.getElementById("course-search").value;
        var instructorSearchValue = document.getElementById("instructor-search").value;
        var majorSelectValue = document.getElementById("major-select").value;
        var campusSearchValue = document.getElementById("campus-search").value;

        var searchQuery = "?course=" + courseSearchValue +
            "&instructor=" + instructorSearchValue +
            "&major=" + majorSelectValue +
            "&campus=" + campusSearchValue;

        window.location.href = "search-result.html" + searchQuery;
    });
});
=======
document.addEventListener('DOMContentLoaded', function() {

});

