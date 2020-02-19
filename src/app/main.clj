(ns app.main
  (:require
    [app.pages.about :as about-page]
    [app.pages.index :as index-page]))


(defn get-pages
  []
  {"/index.html" index-page/get-page
   "/about.html" about-page/get-page})

