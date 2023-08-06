# Gramedia Transaction Automation Testing

# Overview
Gramedia is an Indonesian bookstore owned by Kompas Gramedia. Established in 1970, Gramedia Asri Media has contributed to give inspiration through knowledge, endeavor and direct participation to society for more than 50 years. This automation is created to automate some of transaction flow in Gramedia.com, however, **the automation is only up to choosing payment method **since the environment of this website is production.

## Test Cases

|Test Case| Test Step |
|--|--|
| As a user, I want to add the product to the cart | Given user search a product|
| | When user click the product |
| | And click the book format |
| | And click warehouse |
| | And click “Keranjang"|
| | Then I can see pop up showing “Berhasil Dimasukkan ke Tas Belanja!” |
| As a user, I want to see products in my cart| Given user on Gramedia homepage|
| | When user click cart icon |
| | Then user can see products in cart|
| As a user, I want to remove product from cart| Given user have 1 product in cart|
| | When user click cart icon |
| | And user click “Lihat Keranjang”|
| | And user can see products in cart|
| | And user click “Hapus” in products|
| | And user see pop-up confirmation|
| | And user click “Hapus”|
| | Then cart will be empty|
| As a user, I can see total payment after I reduce quantity of the products*| Given user have 1 product in cart|
| | When user click cart icon |
| | And user click “Lihat Keranjang”|
| | And user can see products in cart|
| | And user click “-” button|
| | Then quantity product will reduce|
| | And total payment will reduce|
| As a user, I can see total payment after I add quantity of the products*| Given user have 1 product in cart|
| | When user click cart icon |
| | And user click “Lihat Keranjang”|
| | And user can see products in cart|
| | And user click “+” button|
| | Then quantity product will increase|
| | And total payment will increase|
| As a user, I want to checkout my cart| Given user have 1 product in cart|
| | When user click cart icon |
| | And user click “Lihat Keranjang”|
| | And user can see products in cart|
| | When user click “Lanjut ke Pembayaran”|
| | And user click “Metode Pengiriman”|
| | And user choose delivery method|
| | And user click “Metode Pembayaran"|
| | And user choose payment method|
| | And user click “Pilih Pembayaran|
| | And user click “Bayar”|
| | Then user will see payment progress page|

***Not Automated Yet**

## Automation Tools
This automation is build using **Selenium**, **Cucumber**, and **Serenity BDD**.

<img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/Selenium_Logo.png" width="200"> <img src="https://cdn.freebiesupply.com/logos/large/2x/cucumber-logo-svg-vector.svg" width="200"> <img src="https://avatars.githubusercontent.com/u/9455201?s=280&v=4" width="200">

## File Structure

| src

|-- test

|   |-- java

|   |  |-- mappers

|   |  |   |-- mappers

|   |  |-- StepDefinition

|   |  |   |-- stepdef

|   |  |-- testRunner

|   |-- resources

|   |  |-- Feature

|   |  |   |-- gramediaTrx.feature

## How To Run

1. Since this automation is using EdgeDriver, you should follow the instruction and download it from here [Use WebDriver to automate Microsoft Edge - Microsoft Edge Development | Microsoft Learn](https://learn.microsoft.com/en-us/microsoft-edge/webdriver-chromium/?tabs=c-sharp)
2. Build gradle
3. After that, you can run the automation via command line:
```
 ./gradlew clean test -Dcucumber.filter.tags="@Gramedia"
```
