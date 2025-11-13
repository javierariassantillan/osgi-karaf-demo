package ec.javi.provider;

import ec.javi.api.SaludoService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

@Component(service = SaludoService.class, immediate = true)
public class SaludoServiceImpl implements SaludoService {

    @Activate
    void activate() {
        System.out.println("[provider] Activado SaludoServiceImpl");
    }

    @Deactivate
    void deactivate() {
        System.out.println("[provider] Desactivado SaludoServiceImpl");
    }

    @Override
    public String saludar(String nombre) {
        return "Hola " + (nombre == null ? "mundo" : nombre) + " desde OSGi!";
    }
}
