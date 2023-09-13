const wetterIn = (city) => {
    const link = {
        url: "https://wttr.in/" + city,
        params: {
            2: "",
            m: "",
            lang: "ru"
        }
    }

    return `${link.url}?${new URLSearchParams(link.params)}`;
}

function getWetter(city) {
    const weter = fetch(wetterIn(city))
        .then(response => response.text())
        .then(pageText => {
            const wetterElement = document.getElementById("wetter-container");
            wetterElement.innerHTML = pageText;
        }).catch((error) => {
            console.error("Ошибка при выполнении запроса", error);
        });

}

const kievElement = document.getElementById("kiev");
kievElement.addEventListener('click',()=>{
    getWetter("Kiev");
});
const londonElement = document.getElementById("london");
londonElement.addEventListener('click',()=>{
    getWetter("London");
});
const berlinElement = document.getElementById("berlin");
berlinElement.addEventListener('click',()=>{
    getWetter("Berlin");
});
const warsawElement = document.getElementById("warsaw");
warsawElement.addEventListener('click',()=>{
    getWetter("Warsaw");
});
const pragueElement = document.getElementById("prague");
pragueElement.addEventListener('click',()=>{
    getWetter("Prague");
});
