# Hola Mundo con Burp Suite Extender
Una simple prueba del API de Burp Suite, 
* Usando maven se requiere solo esta dependencia:

```xml
    <dependencies>
        <dependency>
            <groupId>net.portswigger.burp.extender</groupId>
            <artifactId>burp-extender-api</artifactId>
            <version>${burp-extender-api.version}</version>
        </dependency>
    </dependencies>
```

* Creamos un paquete con el nombre *burp*
* Dentro del paquete burp creamos una clase con el nombre *BurpExtender* que implemente la interface *IBurpExtender*


```java
public class BurpExtender implements IBurpExtender {
	
	@Override
	public void registerExtenderCallbacks(IBurpExtenderCallbacks callbacks) {

	}
}
```

* El API de Burp provee algunos 
