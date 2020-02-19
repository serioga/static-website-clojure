(ns app.pages.index
  (:require
    [app.html.layout :as layout]
    [hiccup.core :as hiccup]))


(defn get-page
  [context]
  (-> [:div
       [:h1 "Homepage"]
       "Page content"
       [:div [:a {:href "/about.html"} "About"]]]
    (hiccup/html)
    (layout/default context)))
