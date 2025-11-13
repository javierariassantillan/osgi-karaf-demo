# OSGi + Apache Karaf Demo

Este proyecto Maven multi-módulo muestra:
- **api**: contrato (`SaludoService`).
- **provider**: implementación y publicación del servicio con **OSGi Declarative Services**.
- **client**: consumidor del servicio y comando Gogo `g:saludar`.

## Requisitos
- Java 17+
- Maven 3.8+
- Apache Karaf 4.4.x (descomprimido en tu máquina)

## Construcción
```bash
mvn clean install
```

## Ejecución en Karaf
1. Inicia Karaf:
   ```bash
   bin/karaf   # (Windows: bin\karaf.bat)
   ```
2. Instala los bundles:
   ```
   bundle:install -s file:/RUTA/osgi-karaf-demo/api/target/api-1.0.0.jar
   bundle:install -s file:/RUTA/osgi-karaf-demo/provider/target/provider-1.0.0.jar
   bundle:install -s file:/RUTA/osgi-karaf-demo/client/target/client-1.0.0.jar
   ```
3. Prueba:
   ```
   g:saludar Javi
   ```
4. Detén/arranca el provider para demostrar dinamismo:
   ```
   bundle:list
   bundle:stop <ID-provider>
   g:saludar Javi
   bundle:start <ID-provider>
   g:saludar Javi
   ```

## Nota
Los módulos están pensados para **bajo acoplamiento**: el `client` depende solo de la **interfaz** del `api`. 
`client` soporta la **ausencia temporal** del servicio gracias a `ReferenceCardinality.OPTIONAL` y `ReferencePolicy.DYNAMIC`.
