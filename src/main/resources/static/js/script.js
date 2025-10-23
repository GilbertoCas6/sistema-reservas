// Script simple para confirmar eliminación
document.addEventListener("DOMContentLoaded", function() {
    const deleteLinks = document.querySelectorAll(".btn-danger");

    deleteLinks.forEach(link => {
        link.addEventListener("click", function(e) {
            const confirmDelete = confirm("¿Estás seguro de eliminar este cliente?");
            if (!confirmDelete) {
                e.preventDefault();
            }
        });
    });
});
