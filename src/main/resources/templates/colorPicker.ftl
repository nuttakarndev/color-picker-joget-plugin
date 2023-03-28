<div class="form-cell" ${elementMetaData!}>
    <link rel="stylesheet" href="${request.contextPath}/plugin/org.joget.ColorPicker/css/colorPick.min.css"/>
    <script type="text/javascript"
            src="${request.contextPath}/plugin/org.joget.ColorPicker/js/colorPick.min.js"></script>
    <style>
        .picker {
            border-radius: 5px;
            width: 36px;
            height: 36px;
            cursor: pointer;
            -webkit-transition: all linear .2s;
            -moz-transition: all linear .2s;
            -ms-transition: all linear .2s;
            -o-transition: all linear .2s;
            transition: all linear .2s;
            border: thin solid #eee;
        }

        .picker:hover {
            transform: scale(1.1);
        }
    </style>
    <label class="label">${element.properties.label}</label>
    <input id="${elementParamName!}" name="${elementParamName!}" type="hidden" value="${value!?html}"/>
    <div class="custom-picker form-cell-value" style="width: 100%; height: 50px"></div>
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