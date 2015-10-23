(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[adzerk/bootlaces   "0.1.11" :scope "test"]
                  [cljsjs/boot-cljsjs "0.5.0" :scope "test"]
                  [cljsjs/jquery      "2.1.4-0"]])

(require '[adzerk.bootlaces :refer :all]
         '[cljsjs.boot-cljsjs.packaging :refer :all])

(def semantic-version "2.1.4")
(def +version+ (str semantic-version "-0"))
(bootlaces! +version+)

(task-options!
  pom {:project     'cljsjs/semantic
       :version     +version+
       :description "semantic ui"
       :url         "https://www.semantic-ui.com"
       :scm         {:url "https://github.com/cljsjs/packages"}
       :license     {"Apache-2.0" "http://opensource.org/licenses/Apache-2.0"}})

(deftask package []
  (deps-cljs :name "cljsjs.semantic"
             :requires ["cljsjs.jquery"]))

