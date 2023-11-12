[#ftl]
[#import "/spring.ftl" as spring]
<!DOCTYPE html>
<html lang="cs">
<head>
    <meta charset="UTF-8">
    <title>Obchůdek pro mlsné jazýčky: čokoláda</title>
    <link rel="stylesheet" href="/style.css"/>
</head>
<body>
<div class="container">
    <form class="kosik" action="/cokolada" method="post">
        <h1>Objednávka čokolády</h1>
        <label for = "druh" class = "radek">Druh čokolády: </label>
            [@spring.formSingleSelect path = "form.druh" options = {
                "":"",
                "1":"mléčná",
                "2":"hořká",
                "3":"bílá",
                "4":"ruby"
            } /]
        <div class = "error"> [@spring.showErrors "<br>"/] </div>

        <label for = "jmeno" class = "radek" > Jméno a příjmení:</label>
        [@spring.formInput path = "form.jmeno" /]
        <div class = "error"> [@spring.showErrors "<br>" /] </div>

        <label for = "email" class = "radek"> E-mail:</label>
        [@spring.formInput path = "form.email"  fieldType="email"/]
        <div class = "error"> [@spring.showErrors "<br>" /] </div>

        <div class = "radek">
            <label for = "obchodniPodminky"> Souhlasím s obchodními podmínkami.</label>
            [@spring.formCheckbox path = "form.obchodniPodminky" /]
        </div>
        <div class = "error"> [@spring.showErrors "<br>" /] </div>
        <!--
        Formulář bude obsahovat:
        * výběr z druhů čokolády, např.: mléčná, bíla, hořká (select)
        * Jméno a příjmení (input)
        * e-mail – volitelný údaj (input)
        * souhlas s obchodními podmínkami (check box)
        -->
        <div class="radek controls">
            <button type="submit">Objednat</button>
        </div>

    </form>
</div>
</body>
</html>
