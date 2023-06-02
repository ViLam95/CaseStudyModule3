document.addEventListener('DOMContentLoaded', function() {
    var dropdowns = document.querySelectorAll('.dropdown');

    dropdowns.forEach(function(dropdown) {
        dropdown.addEventListener('click', function(event) {
            event.stopPropagation(); // Ngăn chặn sự kiện click lan ra các phần tử cha

            var dropdownMenu = this.querySelector('.dropdown-menu');
            dropdownMenu.style.display = (dropdownMenu.style.display === 'block') ? 'none' : 'block';
        });
    });

    // Đóng menu con khi click bên ngoài
    document.addEventListener('click', function() {
        dropdowns.forEach(function(dropdown) {
            var dropdownMenu = dropdown.querySelector('.dropdown-menu');
            dropdownMenu.style.display = 'none';
        });
    });
});
