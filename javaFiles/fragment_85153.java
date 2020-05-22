(defn Article []
  (let [id (atom nil)
        guid  (atom nil)
        title  (atom nil)
        link (atom nil)
        pubdate (atom nil)
        category (atom nil)
        description (atom nil)
        body (atom nil)
        comments (atom nil)

        set (fn [g t l p cg d b cm]
              (do (reset! guid g)
                  (reset! title t)
                  (reset! link l)
                  (reset! pubdate p)
                  (reset! category cg)
                  (reset! description d)
                  (reset! body b)
                  (reset! commments cm)))
        get (fn [] [@guid
                    @link
                    @description
                    @comments
                    :content (content)])

        content #(str title category pubdate body)]
    {:get get, :set set}))