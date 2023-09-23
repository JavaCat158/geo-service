import org.junit.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.Assert.assertEquals;

public class LocalizationServiceImplTest {

    @Test
    public void testLocaleRussia() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();String actual = localizationService.locale(Country.RUSSIA);
        String actualMessage = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", actualMessage);
    }

    @Test
    public void testLocaleAmerica() {
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        String actualMessage = localizationService.locale(Country.USA);
        assertEquals("Welcome", actualMessage);
    }
}
