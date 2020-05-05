;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; This Source Code Form is "Incompatible With Secondary Licenses", as
;; defined by the Mozilla Public License, v. 2.0.
;;
;; Copyright (c) 2020 UXBOX Labs SL

(ns uxbox.worker.thumbnails
  (:require
   [rumext.alpha :as mf]
   [promesa.core :as p]
   [cljs.spec.alpha :as s]
   [uxbox.common.exceptions :as ex]
   [uxbox.common.spec :as us]
   [uxbox.main.fonts :as fonts]
   [uxbox.main.exports :as exports]
   [uxbox.worker.impl :as impl]
   ["react-dom/server" :as rds]))

(defmethod impl/handler :thumbnails/generate
  [{:keys [data] :as message}]
  (let [elem (mf/element exports/page-svg #js {:data data
                                               :width "290"
                                               :height "150"})]
    {:svg (rds/renderToStaticMarkup elem)
     :fonts @fonts/loaded}))
