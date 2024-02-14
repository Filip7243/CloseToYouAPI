# API for CloseToYouAPP

Simple REST API created with Java and SpringBoot for mobile APP [CloseToYou](https://github.com/Filip7243/CloseToYouApp).

## Used Tools

- Java
- SpringBoot
- MongoDB

## How to run

- Execute command `git clone https://github.com/Filip7243/CloseToYouAPI`

- Run MongoDB

- Run app with your IDE

## Requests

### Get Friends Localization

`POST /api/v1/localization`

### Request body

```json
[
  "+48 662-291-021",
  "+48 661-291-021",
  "+48 664-291-021",
  "+48 665-291-021",
  "+48 962-291-021",
  "575603061",
  "+48575603061",
]
```
Numbers can be in any format, because they are parsed later


### Send Localization Data

`PUT /api/v1/localization`

### Payload

``` json
{
    "phoneNumber": "+48663038409",
    "latitude":  11.9440031,
    "longitude": 13.8487769,
    "hasPermission": true
}
```



