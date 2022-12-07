package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MethodSourceTest {

    @BeforeEach
    void openWbCatalogNewYear() {
        open("https://www.wildberries.ru/catalog/novyy-god");
    }

    static Stream<Arguments> wbPageCatalogNewYear() {
        return Stream.of(
                Arguments.of("Елки", List.of("Сортировать по: " +
                        "популярности | рейтингу | цене | обновлению | Сначала выгодные")),
                Arguments.of("Подарки", List.of("Сортировать по: " +
                        "популярности | рейтингу | цене | обновлению | Сначала выгодные")),
                Arguments.of("Вечерний образ", List.of("Сортировать по: " +
                        "популярности | рейтингу | цене | обновлению | Сначала выгодные"))
        );
    }

    @MethodSource("wbPageCatalogNewYear")
    @ParameterizedTest(name = "Отображение списка фильтров {1} " + ", на странице {0}")
    @Tag("BLOCKER")
    void wbPageCatalogNewYear(String category, List<String> filter) {
        sleep(1000);
        $$(".menu-catalog").find(text(category)).click();
        $$(".inner-sorter").filter(visible).shouldHave(CollectionCondition.texts(filter));

    }
}
