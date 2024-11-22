// Get the modal element by its ID
var exampleModal = document.getElementById('editTaskModal');

// Add an event listener for when the modal is about to be shown
exampleModal.addEventListener('show.bs.modal', function (event) {
    // Get the button that triggered the modal
    var button = event.relatedTarget;

    // Extract information from data-bs-* attributes on the button
    var recipient = button.getAttribute('data-bs-whatever');
    var taskId = button.getAttribute('data-task-id');

    // If necessary, you could initiate an AJAX request here
    // and then do the updating in a callback.

    // Get elements inside the modal that need to be updated
    var modalTitle = exampleModal.querySelector('.modal-title');
    var modalBodyTextarea = exampleModal.querySelector('.modal-body textarea');
    var modalBodyInput = exampleModal.querySelector('.modal-body input');
    var modalFooterInput = exampleModal.querySelector('.modal-footer input');

    // Update the modal's content based on the extracted information
    modalTitle.textContent = 'Change text to ' + recipient;
    modalBodyTextarea.value = recipient;
    modalBodyInput.value = taskId;
    modalFooterInput.value = taskId;
});
