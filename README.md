Current application can only work with blog post details by executing GET request at `/posts/{id}`, where `{id}` is a post ID.

Your task is to add comments feature. The application should process following requests:

- `POST` at `/posts/{1}/comments` - which should save a new comment for post with passed `{id}`
- `GET` at `/posts/{1}/comments` - which should return all comments for a post with passed `{id}`
- There is a service class `CommentService` that you should implement. See contents of that class to see detailed requirements. 

You can create additional methods or classes if necessary to create reusable/readable code, but do not alter existing method signatures (their return type, throws clause etc.), or their visibility/structure.

Your solution should satisfy the currently failing tests that are already implemented in the project. The tests themselves should not be changed. However, feel free to add more tests.

The project is set up using Java 8.

Create a new feature branch (for example `assignment`), commit and push your changes. We will review your implementation after you acknowledge us that your work is finished. 
