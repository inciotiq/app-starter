# App Starter

Base app with basic configurations, some utility classes and user management.

## Running the Project

Run the `Application.java` class in the `application` module.

## Modules

- [app-base-starter](https://github.com/inciotiq/app-starter-base): Template for an app using other modules in App
  Starter. Fork this module to make changes.
- [commons](https://github.com/inciotiq/commons): Some fundamental classes and methods.
- [user](https://github.com/inciotiq/app-starter-user): Provides user management with roles.

---

## Troubleshooting

- **jar of a module can not be found:** Modules dependent on other modules (like `user`) can not be run on its own. Try
  running the parent project. If `commons` project can't be found, compile the `commons` project and try running the
  parent project. (Running the parent project means running `Application.java` class in the `application` module)
