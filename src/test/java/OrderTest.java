import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderTest {
        Selenide.open("http://localhost:9999");

    $("[data-test-id='city']").setValue(Челябинск");
    $("[data-test-id='date']").setValue("01.05.2026");

    $("[data-test-id='name']").setValue("Геннадий Челябин");
    $("[data-test-id='phone']").setValue("+79227856768");

    $$("[data-test-id='agreement']").find(Condition.text("Я соглашаюсь с условиями обработки и использования моих персональных данных")).click();

    $$("button").find(Condition.text("Забронировать")).click();

    $(Selectors.withText("Успешно!")).shouldBe(Condition.visible, Duration.ofSeconds(15));


   // $("h2").shouldHave(Condition.text("Личный кабинет"), Duration.ofSeconds(15)).shouldBe(Condition.visible);

}
