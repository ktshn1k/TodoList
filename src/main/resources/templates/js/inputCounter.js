// not used
function updateCharacterCount() {
    // Get the textarea element by its ID
    const textarea = document.getElementById('task');

    // Get the character count element by its ID
    const characterCountElement = document.getElementById('character-count');

    // Get the maxlength attribute from the textarea and parse it to an integer
    const maxLength = parseInt(textarea.getAttribute('maxlength'));

    // Get the current length of the textarea value
    const currentLength = textarea.value.length;

    // Update the text content of the character count element to show the current/maximum character count
    characterCountElement.textContent = currentLength + '/' + maxLength + ' characters';
}
