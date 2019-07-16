@youtube_registration
@test

Feature: Youtube registration

    Background:
        Given open page "https://www.youtube.com/"

        When press button to sign in
        When press button create account
        When press button for myself

    Scenario: Positive test, confirmed email

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS321@gmail.com" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then check text at head page confirmed email "Подтвердите адрес электронной почты"
        Then check text page confirmed email "Введите код подтверждения, отправленный на адрес PropellerADS321@gmail.com. Если письма нет во входящих, проверьте папку "Спам"."


    Scenario: mail is busy

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further
        
        Then text error "Это имя пользователя уже занято. Попробуйте другое."


    Scenario: firstName empty

#        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Укажите имя"


    Scenario: lastName empty

        When set text "Propeller" in input text "firstName"
#        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Укажите фамилию"


    Scenario: email empty

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
#        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Укажите адрес Gmail"


    Scenario: password empty

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

#        When set text "x2!J4*b41" in input password "Passwd"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Введите пароль"


    Scenario: confirm password empty

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
#        When set text "x2!J4*b41" in input password "ConfirmPasswd"
        When press button further

        Then text error "Подтвердите пароль"

#       Исправить
    Scenario: very short password

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "1"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then part text error "Пароль не может быть короче 8"

#       Исправить
    Scenario: very long password

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@gmail.com" in input text "Username"

        When in input password "Passwd" set text "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then part text error "Пароль не может быть длиннее 100"


    Scenario: no character specified '@'

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Не забудьте указать символ "@"."


    Scenario: domain not specified

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Укажите имя домена после символа "@"."


    Scenario: invalid address email

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@123" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b41"
        When press button further

        Then text error "Недействительный адрес электронной почты."


    Scenario: wrong password

        When set text "Propeller" in input text "firstName"
        When set text "ADS" in input text "lastName"
        When set text "PropellerADS@123" in input text "Username"

        When in input password "Passwd" set text "x2!J4*b41"
        When in input password "ConfirmPasswd" set text "x2!J4*b412"
        When press button further

        Then text error "Пароли не совпадают. Повторите попытку."