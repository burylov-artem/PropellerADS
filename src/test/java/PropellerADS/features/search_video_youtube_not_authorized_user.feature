@search_video_youtube_not_authorized_user
@test

Feature: validation request for not authorized user

    Background:
        Given open page "https://www.youtube.com/"

    Scenario: Positive test: valid request

        When set text in search "game of thrones"
        When press button search

        Then We check the correctness of the displayed results on request "game of thrones"


    Scenario: Positive test: valid request, one page

        When set text in search "breaking bad"
        When press button search

        Then We check the correctness of the displayed results on request "breaking bad"


    Scenario: Positive test: valid request, two page

        When set text in search "breaking bad"
        When press button search
        When upload more videos

        Then We check the correctness of the displayed results on request "breaking bad"

    Scenario: Positive test: valid request, three page

        When set text in search "breaking bad"
        When press button search
        When upload more videos
        When upload more videos

        Then We check the correctness of the displayed results on request "breaking bad"


    Scenario: Negative test: valid request, 0000

        When set text in search "0000"
        When press button search
        When upload more videos
        When upload more videos

        Then We check the correctness of the displayed results on request "0000"


    Scenario: Negative test: valid request, @$#&

        When set text in search "@$#&"
        When press button search
        When upload more videos
        When upload more videos

        Then We check the correctness of the displayed results on request "@$#&"


    Scenario: Negative test: valid request, 11111111111111111111111

        When set text in search "11111111111111111111111"
        When press button search
        When upload more videos
        When upload more videos

        Then We check the correctness of the displayed results on request "11111111111111111111111"


    Scenario: Negative test: valid request, 11111111111111111111111111111111111111111

        When set text in search "11111111111111111111111111111111111111111"
        When press button search
        When upload more videos
        When upload more videos

        Then We check the correctness of the displayed results on request "11111111111111111111111111111111111111111"


    Scenario: Negative test: No results found

        When set text in search "----------"
        When press button search
        When upload more videos
        When upload more videos

        Then text message on error "Результатов не найдено"
        Then text message on error "Поищите по другим ключевым словам или уберите примененные фильтры."


    Scenario: Negative test: XSS <script>alert(1)</script>

        When set text in search "<script>alert(1)</script>"
        When press button search
        When upload more videos
        When upload more videos

        Then We check the correctness of the displayed results on request "<script>alert(1)</script>"





