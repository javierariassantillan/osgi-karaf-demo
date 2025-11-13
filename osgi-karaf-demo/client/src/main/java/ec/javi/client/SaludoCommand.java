package ec.javi.client;

import ec.javi.api.SaludoService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

@Component(
  service = Object.class,
  property = {
    "osgi.command.scope=g",
    "osgi.command.function=saludar"
  },
  immediate = true
)
public class SaludoCommand {

    @Reference(
      service = SaludoService.class,
      cardinality = ReferenceCardinality.OPTIONAL,
      policy = ReferencePolicy.DYNAMIC,
      policyOption = ReferencePolicyOption.GREEDY
    )
    volatile SaludoService saludoService;

    public void saludar(String nombre) {
        SaludoService s = this.saludoService;
        if (s == null) {
            System.out.println("[client] Servicio no disponible ahora mismo. Intenta más tarde.");
        } else {
            System.out.println(s.saludar(nombre));
        }
    }

    protected void bindSaludoService(SaludoService s) { /* opcional */ }
    protected void unbindSaludoService(SaludoService s) { /* opcional */ }
}
