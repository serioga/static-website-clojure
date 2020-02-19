(ns dev.builder
  (:require
    [app.main :as pages]
    [clojure.java.io :as io]
    [me.raynes.fs :as fs]
    [stasis.core :as stasis]))


(defn ^:private copy-dir-into
  "Modified `fs/copy-dir-into` with skipped directories."
  [from to skip-dirs]
  (when-not (fs/exists? to)
    (fs/mkdir to))
  (doseq [file (fs/list-dir from)]
    (let [base-name (fs/base-name file)]
      (cond
        (fs/file? file)
        (fs/copy file (io/file to base-name))

        (not (skip-dirs base-name))
        (fs/copy-dir file to)

        :else (do :nothing)))))


(defn export-stasis-pages
  [target-dir]
  (stasis/export-pages (pages/get-pages) target-dir {:release? true}))


(defn copy-public-resources
  [target-dir]
  (copy-dir-into "resources/public" target-dir #{"app"}))


(defn build-site
  []
  (doto "release"
    (export-stasis-pages)
    (copy-public-resources)))


#_(comment
    (build-site)

    (copy-dir-into "resources/public" "release" #{"app"}))
