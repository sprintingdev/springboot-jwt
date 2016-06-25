# springboot-jwt

A spring-boot/gradle based implementation of the blog post from http://niels.nu/blog/2015/json-web-tokens.html.
The project currently only has the controller layer with scope for addition of UI in the future. This can also be used as a boiler plate for JWT security based applications.

## Changes from original project
* Extracted Authentication logic to its own bean.
* Custom Authentication Exception thrown instead of Generic ServletException.
* Authenticator can be extended by other username/password authentication logic.
