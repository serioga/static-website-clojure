(ns app.pages.about
  (:require
    [app.html.layout :as layout]
    [hiccup.core :as hiccup]))


(defn get-page
  [context]
  (-> [:div
       [:h1 "About company"]
       "Page content"
       [:div [:a {:href "/"} "Home"]]]
    (hiccup/html)
    (layout/default context)))
