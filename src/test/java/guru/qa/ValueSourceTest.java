package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ValueSourceTest extends TestBase {

    @ValueSource(strings = {
            " Адреса ",
            " Войти ",
            " Корзина "
    })
    @ParameterizedTest(name = "Поиск вкладки {0} сайта wildberries.ru")
    @Tag("BLOCKER")
    void wbPageTest(String page) {
        $$(".header__bottom").find(text(page));
    }
}
