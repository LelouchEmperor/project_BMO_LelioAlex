# Diagramme de classe

## Entités principales :

- **Utilisateur :** Un utilisateur représente une personne qui utilise le système de paris en ligne. Chaque utilisateur a un identifiant unique, un nom d'utilisateur et est associé à un compte.

- **Compte :** Un compte représente les informations associées à un utilisateur, telles que son adresse e-mail, son mot de passe, et le nombre de jetons disponibles pour parier.

- **Pari :** Un pari est une mise faite par un utilisateur sur un événement sportif. Chaque pari a un identifiant unique, ainsi que des détails tels que le montant misé, l'événement sur lequel le pari est placé, et le résultat du pari.Le pari est créer par un bookmaker

- **Bookmaker :** Un bookmaker est une entité qui fixe les cotes et les limites pour les paris. Chaque bookmaker a un identifiant unique ainsi qu'un nom et prénom, et peut limiter les cotes et les montants maximums des paris. Un bookmaker peut créer plusieurs paris

- **Résultat :** Un résultat représente le score ou le résultat d'un événement sportif sur lequel un pari a été placé. Chaque résultat est associé à un match spécifique.

- **Type de Pari :** Un type de pari définit la nature du pari, comme par exemple "vainqueur", "score final", etc. Chaque type de pari a un identifiant unique et une description.

- **Type de Sport :** Un type de sport représente une catégorie sportive, comme le football, le basketball, etc. Chaque type de sport a un identifiant unique, un nom et un nombre de périodes.

- **Événement :** Un événement représente un événement sportif spécifique sur lequel les utilisateurs peuvent parier. Chaque événement a un identifiant unique, un nom, une date et est associé à un type de sport spécifique.

## Associations :

- Un événement est associé à un type de sport spécifique, ce qui signifie qu'un événement appartient à une catégorie sportive particulière.

- Un pari est effectué par un utilisateur donné, ce qui signifie qu'un utilisateur fait un pari.

- Chaque utilisateur possède un compte, ce qui signifie qu'un utilisateur est associé à un compte spécifique.

- Un type de pari est associé à plusieurs paris, ce qui signifie qu'un type de pari peut être utilisé pour plusieurs paris.

- Un bookmaker peut être associé à plusieurs paris, ce qui signifie qu'un bookmaker peut fixer les cotes pour plusieurs paris.

- Un pari est associé à un résultat spécifique, ce qui signifie qu'un pari est lié à un résultat spécifique d'un événement sportif.

- Un événement est associé à plusieurs paris, ce qui signifie qu'un événement peut avoir plusieurs paris placés sur lui.
