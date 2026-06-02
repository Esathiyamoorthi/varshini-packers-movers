// Scroll Animation
const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
        if(entry.isIntersecting){
            entry.target.style.opacity = 1;
            entry.target.style.transform = "translateY(0)";
        }
    });
});

document.querySelectorAll('.card').forEach(card => {
    card.style.opacity = 0;
    card.style.transform = "translateY(50px)";
    observer.observe(card);
});

// Navbar hide on scroll down, show on scroll up
let lastScroll = 0;
const navbar = document.querySelector("nav");

window.addEventListener("scroll", () => {
    let currentScroll = window.pageYOffset;

    if (currentScroll > lastScroll) {
        navbar.style.top = "-80px"; // hide
    } else {
        navbar.style.top = "0"; // show
    }

    lastScroll = currentScroll;
});



//backend









