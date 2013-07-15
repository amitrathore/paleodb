(ns paleodb.foods.nutrition
  (:use zolo.utils.debug
        zolo.utils.clojure))

(def FOODS {
            :beef {:tags [:meat :organic]}
            :bison {:tags [:meat :organic]}
            :boar {:tags [:meat :organic]}
            :buffalo {:tags [:meat :organic]}
            :chicken {:tags [:meat :organic]}
            :duck {:tags [:meat :organic]}
            :eggs {:tags []}
            :game {:tags [:meat :organic]}
            :goat {:tags [:meat :organic]}
            :goose {:tags [:meat :organic]}
            :lamb {:tags [:meat :organic]}
            :mutton {:tags [:meat :organic]}
            :ostrich {:tags [:meat :organic]}
            :pork {:tags [:meat :organic]}
            :quail {:tags [:meat :organic]}
            :rabbit {:tags [:meat :organic]}
            :squab {:tags [:meat :organic]}
            :turkey {:tags [:meat :organic]}
            :veal {:tags [:meat :organic]}
            :venison {:tags [:meat :organic]}
            :catfish {:tags [:seafood :fish]}
            :carp {:tags [:seafood :fish]}
            :clams {:tags [:seafood]}
            :grouper {:tags [:seafood :fish]}
            :halibut {:tags [:seafood :fish]}
            :herring {:tags [:seafood :fish]}
            :lobster {:tags [:seafood]}
            :mackerel {:tags [:seafood :fish]}
            :mahi-mahi {:tags [:seafood :fish]}
            :mussels {:tags [:seafood]}
            :oysters {:tags [:seafood]}
            :salmon {:tags [:seafood :fish]}
            :sardines {:tags [:seafood :fish]}
            :scallops {:tags [:seafood :fish]}
            :shrimp {:tags [:seafood]}
            :prawns {:tags [:seafood]}
            :snails {:tags [:seafood]}
            :snapper {:tags [:seafood :fish]}
            :swordfish {:tags [:seafood :fish]}
            :trout {:tags [:seafood :fish]}
            :tuna {:tags [:seafood :fish]}
            :liver {:tags [:super-food]}
            :kidney {:tags [:super-food]}
            :heart {:tags [:super-food]}

            :seaweed {:tags [:super-food :vegetable]}
            :kelp {:tags [:super-food]}
            :dulse {:tags [:super-food]}
            :bone-broth {:tags [:super-food :home-made]}

            :sauerkraut {:tags [:fermented :super-food :goitrogenic]}
            :carrots {:tags [:fermented :super-food :vegetable :organic]}
            :beets {:tags [:fermented :super-food :vegetable :fodmap]}
            :yogurt {:tags [:fermented :super-food]}
            :kefir {:tags [:fermented :super-food]}
            :kombucha {:tags [:fermented :super-food]}
            
            :avocado-oil {:tags [:oil :cold-pressed :organic :extra-virgin]}
            :bacon-fat {:tags [:fat]}
            :lard {:tags [:fat]}
            :butter {:tags [:fat :grass-fed :super-food]}
            :coconut-milk {:tags [:fat]}
            :coconut-oil {:tags [:oil :unrefined]}
            :duck-fat {:tags [:fat]}
            :ghee {:tags [:fat :grass-fed :super-food]}
            :macadamia-oil {:tags [:oil :cold-pressed :organic :extra-virgin]}
            :olive-oil {:tags [:oil :extra-virgin :cold-pressed :organic]}
            :palm-oil {:tags [:oil :unrefined]}
            :schmaltz {:tags [:fat :chicken]}
            :sesame-oil {:tags [:oil :cold-pressed :organic :extra-virgin]}
            :suet {:tags [:oil]}
            :tallow {:tags [:fat :beef]}
            :walnut-oil {:tags [:oil :cold-pressed :organic :extra-virgin]}

            :milk {:tags [:organic]}

            :almonds {:tags [:nut]}
            :brazil-nuts {:tags [:nut]}
            :chestnuts {:tags [:nut]}
            :hazelnuts {:tags [:nut]}
            :macadamia-nuts {:tags [:nut]}
            :pecans {:tags [:nut]}
            :pine-nuts {:tags [:nut]}
            :pistachios {:tags [:fodmap ]}
            :pumpkin-seeds {:tags [:seed]}
            :sesame-seeds {:tags [:seed]}
            :sunflower-seeds {:tags [:seed]}
            :walnuts {:tags [:nut]}

            :almond-milk {:tags [:beverage]}
            :coconut-water {:tags [:beverage]}
            :herbal-tea {:tags [:beverage]}
            :green-tea {:tags [:beverage]}
            :coffee {:tags [:beverage :organic]}
            :white-tea {:tags [:beverage]}
            :mineral-water {:tags [:beverage]}
            :water {:tags [:beverage]}

            :artichokes {:tags [:fodmap :vegetable]}
            :asparagus {:tags [:fodmap :vegetable]}
            :arugula {:tags [:vegetable]}
            :bamboo-shoots {:tags [:vegetable]}
            :bok-choy {:tags [:goitrogenic :vegetable]}
            :broccoli {:tags [:fodmap :goitrogenic :vegetable]}
            :brussel-sprouts {:tags [:fodmap :goitrogenic :vegetable]}
            :cabbage {:tags [:fodmap :vegetable]}
            :cassava {:tags [:vegetable]}
            :cauliflower {:tags [:fodmap :goitrogenic :vegetable]}
            :celery {:tags [:organic :vegetable]}
            :chard {:tags [:vegetable]}
            :collard-greens {:tags [:goitrogenic :organic :vegetable]}
            :cucumbers {:tags [:organic :vegetable]}
            :daikon {:tags [:vegetable]}
            :dandelion-greens {:tags [:fodmap :vegetable]}
            :eggplant {:tags [:vegetable]}            
            :endive {:tags [:vegetable]}
            :fennel {:tags [:fodmap :vegetable]}
            :garlic {:tags [:fodmap :vegetable]}
            :green-beans {:tags [:vegetable]}
            :green-onions {:tags [:fodmap :vegetable]}
            :jicama {:tags [:fodmap :vegetable]}
            :kale {:tags [:goitrogenic :organic :vegetable]}
            :kohlrabi {:tags [:goitrogenic :vegetable]}
            :leeks {:tags [:fodmap :vegetable]}
            :lettuce {:tags [:organic :vegetable]}
            :lotus-roots {:tags [:vegetable]}
            :mushrooms {:tags [:fodmap :vegetable]}
            :mustard-greens {:tags [:fodmap :vegetable]}
            :okra {:tags [:vegetable]}
            :onions {:tags [:fodmap :vegetable]}
            :parsley {:tags [:vegetable]}
            :parsnips {:tags [:vegetable]}
            :peppers {:tags [:fodmap :organic :vegetable]}
            :potatoes {:tags [:organic :vegetable]}
            :purslane {:tags [:vegetable]}
            :radicchio {:tags [:vegetable]}
            :radishes {:tags [:goitrogenic :vegetable]}
            :rapini {:tags [:goitrogenic :vegetable]}
            :rutabagas {:tags [ :vegetable]}
            :shallots {:tags [:fodmap :vegetable]}
            :snap-peas {:tags [:vegetable]}
            :spinach {:tags [:goitrogenic :organic :vegetable]}
            :squash {:tags [:vegetable]}
            :sugar-snaps {:tags [:vegetable]}
            :sunchokes {:tags [:fodmap :vegetable]}
            :sweet-potatoes {:tags [:goitrogenic :vegetable]}
            :taro {:tags [:vegetable]}
            :tomatillos {:tags [:vegetable]}
            :tomatoes {:tags [:organic :vegetable]}
            :turnip-greens {:tags [:vegetable]}
            :turnips {:tags [:vegetable]}
            :watercress {:tags [:goitrogenic :vegetable]}
            :yams {:tags [:vegetable]}
            :yuccas {:tags [:vegetable]}
            :zuchini {:tags [:organic :vegetable]}

            :apples {:tags [:fodmap :organic :fruit]}
            :apricots {:tags [:fodmap :fruit]}
            :avacados {:tags [:fodmap :fruit]}
            :bananas {:tags [:fruit]}
            :blackberries {:tags [:fodmap :fruit]}
            :blueberries {:tags [:organic :fruit]}
            :cherries {:tags [:fodmap :fruit]}
            :cranberries {:tags [:fruit]}
            :figs {:tags [:fodmap :fruit]}
            :grapefruit {:tags [:fruit]}
            :grapes {:tags [:organic :fruit]}
            :guavas {:tags [:fruit]}
            :kiwis {:tags [:fruit]}
            :lemons {:tags [:fruit]}
            :limes {:tags [:fruit]}
            :lychees {:tags [:fodmap :fruit]}
            :mangoes {:tags [:fodmap :fruit]}
            :melons {:tags [:fruit]}
            :nectarines {:tags [:fodmap :organic :fruit]}
            :organges {:tags [:fruit]}
            :papayas {:tags [:fruit]}
            :passionfruit {:tags [:fruit]}
            :peaches {:tags [:fodmap :organic]}
            :pears {:tags [:fodmap :fruit]}
            :persimmions {:tags [:fruit]}
            :pineapples {:tags [:fruit]}
            :plaintains {:tags [:fruit]}
            :plums {:tags [:fruit]}
            :pomegranates {:tags [:fruit]}
            :raspberries {:tags [:fruit]}
            :rhubarb {:tags [:fruit]}
            :starfruit {:tags [ :fruit]}
            :strawberries {:tags [:fodmap :organic :fruit]}
            :tangerines {:tags [ :fruit]}
            :watermelons {:tags [ :fruit]}

            })

(def BAD [:fodmap :phytates :gluten])

(def POISON {
             :margarine {:tags []}
             :canola-oil {:tags []}
             :corn-oil {:tags []}
             :vegetable-oil {:tags []}
             :soybean-oil {:tags []}
             :grapeseed-oil {:tags []}
             :sunflower-oil {:tags []}
             :safflower-oil {:tags []}
             :rice-bran-oil {:tags []}
             
             })

(def fodmap "FODMAPs are short chain carbohydrates and monosaccharides that are poorly absorbed in the small intestine, including fructans, galactans, fructose and polyols. The term is an acronym, deriving from 'Fermentable, Oligo-, Di-, Mono-saccharides And Polyols'. The restriction of FODMAPs from the diet has been found to have a beneficial effect for sufferers of irritable bowel syndrome and other functional gut disorders. The low FODMAP diet was developed at Monash University in Melbourne.")







