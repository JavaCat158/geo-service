import org.junit.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.Assert.assertEquals;

public class GeoServiceImplTest {
    private static final String Russian_IP = "172.0.32.11";
    private static final String American_IP = "96.44.183.149";

    @Test
    public void testByRussianLocation() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(Russian_IP);

        assertEquals("Moscow", location.getCity());
        assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    public  void testByAmericanLocation() {
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = geoService.byIp(American_IP);

        assertEquals("New York", location.getCity());
        assertEquals(Country.USA, location.getCountry());
    }
}
