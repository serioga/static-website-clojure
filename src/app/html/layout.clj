(ns app.html.layout
  (:require
    [app.config.core :as config]
    [hiccup.page :as hiccup-page])
  (:import
    (java.time Year)))


(defn copyright-year
  "Auto updated year. The tag for nginx SSI."
  [{:keys [release?]}]
  (if release?
    "<!--#config timefmt=\"%Y\" --><!--#echo var=\"DATE_GMT\" -->"
    (str (Year/now))))


(defn copyright
  [context]
  (list
    "Copyright &copy; " (copyright-year context) " " config/company-name))


(defn default
  [page {:keys [lang] :as context}]
  (hiccup-page/html5 {:lang lang}
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:name "viewport"
             :content "width=device-width, initial-scale=1.0"}]
     [:title config/company-name]
     [:link {:rel "stylesheet" :href "/app/main.css"}]]
    [:body
     [:div.page-body page]
     [:div.page-footer
      [:div.container
       [:div.copyright (copyright context)]]]]))

