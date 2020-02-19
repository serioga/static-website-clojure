# static-website-clojure
Prototype of Clojure project for static website development

## Features

- Hiccup
- Tailwind CSS
- Clojure
- Hor reloading

## Usage

Run for development:

    npx nf -p 8080 start

Build static website:

    lein release

.Run web server for release version:

    lein with-profile test-release ring server

