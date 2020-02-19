(ns dev.server
  (:require
    [app.main :as pages]
    [ring.middleware.resource :as ring-resource]
    [stasis.core :as stasis]))


(def ring-handler
  (-> (stasis/serve-pages pages/get-pages)
    (ring-resource/wrap-resource "public")))


(defn wrap-dir-index
  [handler]
  (fn [req]
    (handler
      (update-in req [:uri]
         #(if (= "/" %) "/index.html" %)))))


(def test-release-handler
  (-> identity
    (ring-resource/wrap-resource "")
    (wrap-dir-index)))


#_(comment
    ring-handler
    test-release-handler)
