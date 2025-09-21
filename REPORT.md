# Lab 1 Git Race -- Project Report

## Description of Changes
In this project, several key improvements were made to the application:

1. **Time-based personalization of the `/api/hello` endpoint:**  
   - The `TimeGreetingService` was created to generate personalized greetings depending on the current time of day (morning, afternoon, or evening) and the user-provided name.  
   - The `/api/hello` endpoint now responds with a dynamic and contextual message, improving the overall user experience.

2. **Internationalization (i18n):**  
   - Multi-language support (English, Spanish, and French) was implemented through `messages.properties` files.  
   - A `LocaleResolver` and a `LocaleChangeInterceptor` were configured to allow the language to be changed dynamically via a selector in the web interface.  
   - A language selector was added to the web interface.

3. **Documentation with Swagger:**  
   - **Swagger/OpenAPI** was integrated to automatically document the API endpoints.  
   - This allows for interactive exploration and testing of the endpoints without needing external tools.

4. **Update of unit and integration tests:**  
   - The existing tests were modified to adapt them to the new personalized greeting and internationalization features.  
   - Additional validations were added to:
     - Ensure that the greeting changes depending on the time of day.  
     - Verify that the `/api/hello` endpoint returns the correct message.  

## Technical Decisions
- For internationalization, `ReloadableResourceBundleMessageSource` was configured with UTF-8 encoding to ensure that texts are loaded correctly.  
- A **custom service (`TimeGreetingService`)** was implemented to encapsulate the logic for generating dynamic greetings, keeping the code modular, maintainable, and reusable both in the API and in the tests.  
- **Swagger** was chosen for API documentation because it provides a standardized and visual way to explore and test endpoints easily.  

## Learning Outcomes
- I learned how to configure a multi-language system in Spring Boot, managing languages through property files and cookies.  
- I understood how to structure business logic into reusable services, applying good software design practices.  
- I gained experience integrating Swagger for interactive REST API documentation.  
- I deepened my understanding of the importance of maintaining modularity and clarity in the backend code structure.

## AI Disclosure
### AI Tools Used
- ChatGPT

### AI-Assisted Work
- AI was used to generate language translations in the `messages_<language>.properties` files.  
- The percentage of AI-assisted work is **20%**.  
- All AI-generated content was reviewed and manually adjusted before being integrated into the project.

### Original Work
- The implementation of the `TimeGreetingService` and the modification of the `/api/hello` endpoint were done manually by the team.  
- The final configuration of Swagger and the property files loading were carried out directly by the developers without AI assistance.  
- The web interface remained unchanged, but its behavior was analyzed to ensure proper integration with the backend changes.
- The modification of the tests was done entirely manually without AI assistance.    
