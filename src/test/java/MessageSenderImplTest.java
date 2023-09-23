import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MessageSenderImplTest {
    private static final String RUSSIAN_IP = "172.0.32.11";
    private static final String AMERICAN_IP = "96.44.183.149";

    @Test
    public void testRussianMessage() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        when(geoService.byIp(RUSSIAN_IP)).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap();
        headers.put("x-real-ip", RUSSIAN_IP);

        String actualMessage = messageSender.send(headers);
        assertEquals("Добро пожаловать", actualMessage);
    }

    @Test
    public void testEnglishMessage() {
        GeoService geoService = Mockito.mock(GeoService.class);
        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        when(geoService.byIp(AMERICAN_IP)).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        Map<String, String> headers = new HashMap();
        headers.put("x-real-ip", AMERICAN_IP);

        String actualMessage = messageSender.send(headers);
        assertEquals("Welcome", actualMessage);
    }
}