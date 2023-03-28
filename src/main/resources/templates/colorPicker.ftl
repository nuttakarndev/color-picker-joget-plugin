<div class="form-cell" ${elementMetaData!}>
    <link rel="stylesheet" href="${request.contextPath}/plugin/org.joget.ColorPicker/css/colorPick.min.css"/>
    <script type="text/javascript"
            src="${request.contextPath}/plugin/org.joget.ColorPicker/js/colorPick.min.js"></script>
    <label class="label">${element.properties.label}</label>
    <input id="${elementParamName!}" name="${elementParamName!}" type="hidden" value="${value!?html}"/>
    <div class="custom-picker form-cell-value" style="width: 200px; height: 50px"></div>
    <script>
        $(".custom-picker").colorPick({
            'initialColor': '#8e44ad',
            'onColorSelected': function () {
                $('#${elementParamName!}').val(this.color)
                this.element.css({'backgroundColor': this.color, 'color': this.color});
            }
        });
    </script>
</div>