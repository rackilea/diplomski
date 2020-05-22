<s:form action="Modmed" id="Modmed" namespace="/pages" theme="bootstrap" cssClass="bs-example form-horizontal">

               <s:textfield label="Identifiant" type="Number" min="1" name="idmed"  value="%{idmed}"/>
                <s:textfield label="Nom" name="nom" value="%{nom}" />
                <s:textfield label="Prenom" name="prenom"  value="%{prenom}" />
                <s:textfield label="Contact" name="contact" value="%{contact}" />
                <s:textfield label="Spécialité" name="specialite" value="%{specialite}"/>

                <div class="col-lg-9 col-lg-offset-3">
                <s:submit cssClass="btn btn-primary" value="Sauvegarder"/>

    </div>
            </s:form>