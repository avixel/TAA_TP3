# TP3: Le framework Spring

## Partie I : Injection de dépendances

Pour cette partie j'ai suivi les instructions concernant les interfaces, qui se situent dans le package app.interfaces.

Les beans se situent dans le package app.beans, implémentant les interfaces concues précédemment.
J'ai créé 3 classes pour contenir les données (package app.data) :
   - Account : Contient l'identifiant (String) du propriétaire du compte ainsi que l'argent restant.
   - Item : Article simple (id et prix) sans la quantité
   - ItemSell : Correspond à un article du magasin (identique à Item mais avec la quantité de l'objet)
   
Dans les beans Store, Provider et Bank, j'ai ajouté une méthode pour retrouver plus facilement une donnée (Account, Item, ItemSell).

La classe Main du package app permet de lancer le projet.

## Partie II : Spring AOP

Pour cette partie, une seule classe a été ajoutée, LogSecurityAspect (package app), un Aspect contenant deux méthodes :
  - logServiceAccess (@Before("execution(* app..*.*(..))")) permettant d'afficher dans la console chaque méthode (du package app) appellée et à quelle classe/bean          elle appartient.
  - securityServiceAccess (@Around("execution(* app..*.*(..))")) sensée gérer la sécurité des méthodes appellées (les mêmes que la méthode précédente),
      ici, cette méthode ne contient que l'instruction pour lancer la méthode, mais j'avais pensé, du point de vue de la sécurité, à vérifier que les arguments           passés étaient différents de "null".
