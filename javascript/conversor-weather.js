/*jshint esversion: 6 */

// kelvin value is 293
let kelvin = 293;

// celsius value is kelvin - 273
let celsius = kelvin - 273;

// fahrenheit value is celsius * (9/5) + 32
let fahrenheit = celsius * (9/5) + 32;

fahrenheit = Math.floor(fahrenheit);

console.log(`Kelvin: ${kelvin} \nCelsius: ${celsius} \nFahrenheit: ${fahrenheit}`);