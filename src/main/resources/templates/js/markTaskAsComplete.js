// Function to submit the form when any checkbox is changed
function submitFormOnCheckboxChange() {
    // Get all checkboxes with the class 'form-check-input'
    const checkboxes = document.querySelectorAll('.form-check-input');

    // Loop through each checkbox
    checkboxes.forEach(checkbox => {
        // Add an event listener for the 'change' event on each checkbox
        checkbox.addEventListener('change', function () {
            // Find the closest form element to the checkbox
            const form = this.closest('form');

            // Submit the form
            form.submit();
        });
    });
}

// Attach the function to the 'DOMContentLoaded' event to ensure it runs after the document is fully loaded
document.addEventListener('DOMContentLoaded', submitFormOnCheckboxChange);
