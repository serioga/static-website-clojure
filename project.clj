(defproject name.trofimov/static-website-clojure "1.0.0-SNAPSHOT"

  :dependencies [[hiccup "1.0.5"]
                 [me.raynes/fs "1.4.6"]
                 [nrepl "0.6.0"]
                 [org.clojure/clojure "1.10.0"]
                 [ring "1.8.0"]
                 [stasis "2.5.0"]]

  :plugins [[lein-ring "0.12.5"]
            [lein-shell "0.5.0"]]

  :clean-targets ^{:protect false} ["release"]

  :shell {:commands {"node_modules/.bin/postcss"
                     {:windows "node_modules/.bin/postcss.cmd"}}}

  :aliases {"css-dev" ["shell" "node_modules/.bin/postcss"
                       "tailwind/app/main.css" "-o" "resources/public/app/main.css"]

            "css-dev-auto" ["shell" "node_modules/.bin/postcss"
                            "tailwind/app/main.css" "-o" "resources/public/app/main.css"
                            "--watch" "--poll" "300"]

            "css-release" ["shell" "node_modules/.bin/postcss"
                           "tailwind/app/main.css" "-o" "release/app/main.css"
                           "--config" "tailwind/release/"]

            "build-site" ["run" "-m" "dev.builder/build-site"]

            "release" ["do" "clean," "build-site," "css-release"]}

  :ring {:host "website.localtest.me"}

  :profiles {:dev {:ring {:handler dev.server/ring-handler
                          :auto-refresh? true
                          :nrepl {:start? true}}}

             :test-release {:resource-paths ["release"]
                            :ring {:handler dev.server/test-release-handler}}

             :css {:source-paths ["tailwind"]}})
