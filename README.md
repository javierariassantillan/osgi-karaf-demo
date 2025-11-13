🚀 Proyecto OSGi con Apache Karaf – Ejemplo con API, Provider y Client

Este proyecto implementa un ejemplo funcional de arquitectura OSGi utilizando Apache Karaf, mostrando cómo construir módulos con bajo acoplamiento que pueden instalarse, iniciarse, detenerse y reemplazarse sin afectar la ejecución del sistema.

🎯 Objetivo del Proyecto

Comprender cómo funciona OSGi.

Identificar los patrones de arquitectura que utiliza.

Implementar tres bundles funcionales: api, provider y client.

Ejecutarlos dentro de Apache Karaf, demostrando modularidad real.

🧩 Patrones de Arquitectura Relacionados

Arquitectura Modular

Microkernel (Plug-in Architecture)

Inversión de Control

Service Registry Pattern

Component-Based Architecture

Estos patrones permiten que los módulos puedan activarse/desactivarse sin detener la aplicación completa.

📁 Estructura del Proyecto
osgi-karaf-demo/
├── api
├── provider
└── client

¿Qué hace cada módulo?

api → Define la interfaz SaludoService.

provider → Implementa la interfaz y publica el servicio usando Declarative Services.

client → Consume el servicio publicado por el provider.

🛠️ Requisitos

Java 17+

Maven 3.8+

Apache Karaf 4.4.x (descomprimido en tu máquina)

🏗️ Construcción del Proyecto

Ejecuta en la raíz del proyecto:

mvn clean install


Esto generará los .jar de cada módulo dentro de sus respectivas carpetas target.

▶️ Ejecución en Karaf
1. Inicia Karaf
   bin/karaf


(En Windows: bin\karaf.bat)

2. Instala los bundles

Usa las rutas absolutas a tus .jar generados:

bundle:install -s file:///RUTA/osgi-karaf-demo/api/target/api-1.0.0.jar
bundle:install -s file:///RUTA/osgi-karaf-demo/provider/target/provider-1.0.0.jar
bundle:install -s file:///RUTA/osgi-karaf-demo/client/target/client-1.0.0.jar

3. Verifica que los bundles estén activos
   bundle:list


Debes ver algo como:

54 │ Active │ 80 │ 1.0.0 │ osgi-karaf-demo-api
55 │ Active │ 80 │ 1.0.0 │ osgi-karaf-demo-provider
60 │ Active │ 80 │ 1.0.0 │ osgi-karaf-demo-client

4. Prueba el servicio

El client expone un comando Gogo:

g:saludar


Si todo está correcto deberías ver el mensaje del provider.

🔥 Conclusiones

Este proyecto demuestra una arquitectura modular real utilizando OSGi + Karaf, con servicios dinámicos que pueden instalarse, iniciarse o detenerse sin interrumpir el resto del sistema.

👨‍💻 Autor

Javier Arias Santillán – Ingeniería de Software