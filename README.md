# Summary
REST APIs samples in Jersey and RESTEasy with HATEOAS and Swagger documentation

# REST APIs
- REST is an architectural style based on web-standards and HTTP protocol. 
- REST was first described by Roy Fielding in 2000.
- In a REST based architecture everything is a resource. A resource is accessed via a common interface based on the HTTP standard methods.
- In a REST based architecture you typically have a REST server which provides access to the resources and a REST client which accesses and modifies the REST resources.
- Every resource should support the HTTP common operations.
- Resources are identified by global IDs (which are typically URIs).
- REST allows that resources have different representations, e.g., text, XML, JSON etc.
- The REST client can ask for a specific representation via the HTTP protocol (content negotiation).

# HATEOAS
- HATEOAS (Hypermedia as the Engine of Application State) is a constraint of the REST application architecture.
- A hypermedia-driven site provides information to navigate the site's REST interfaces dynamically by including hypermedia links with the responses.
- It differs from SOA-based and WSDL-driven interfaces.

# ETags
- Entity Tags are useful HTTP headers which can be used to build a super fast application by minimizing the server load on system.
- ETag is set in the client response so that client can use different control request headers such as If-Match and If-None-Match for conditional requests.
- On server side, a unchanged ETag (match done between ETag attached with HTTP request and ETag calculated for requested resource) means, a resource is unchanged from last requested time, so sending a HTTP 304 header [Not Modified] will be enough for the client to use local copy of resource.

