package guru.qa;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CsvSourceTest extends TestBase {

    @CsvSource({
            "Обувь, Балетки",
            "Куртка, Косуха",
            "Очки, Очки для компьютера"
    })

    @ParameterizedTest(name = "Проверка отображения информации категории {1} " + ", при запросе {0}")
    @Tag("BLOCKER")
    void wbApplicationsTest(String searchApplications, String categoryApplications) {
        sleep(1000);
        $("#searchInput").setValue(searchApplications).pressEnter();
        $(".catalog-page__filters").shouldHave(text(categoryApplications));
    }
}
