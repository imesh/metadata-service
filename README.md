Metadata Service
================

This is a metadata service implemented with JAX/RS. Build and deploy the services.war file in a Tomcat instance.

Metadata POST Request:
POST http://localhost:8080/services/metadata/{environment-id}
{"name":"property-name","value":"property-value"}

Metadata GET Request:
GET http://localhost:8080/services/metadata/{environment-id}/{property-name}

Metadata DELETE Request:
DELETE http://localhost:8080/services/metadata/{environment-id}/{property-name}


Sample POST Request:
curl -v -H "Content-Type: application/json" -d '{"name":"xyz","value":"abc"}' http://localhost:8080/services/metadata/dev

Sample GET Request:
curl -v -X GET http://localhost:8080/services/metadata/dev/xyz/

Sample DELETE Request:
curl -v http://localhost:8080/services/metadata/dev/xyz/