document.addEventListener('DOMContentLoaded', function() {
    const coreTypeSelect = document.getElementById('coreType');
    const dynamicFields = document.getElementById('dynamicFields');
    const calculateButton = document.getElementById('calculateButton');
    const resultDiv = document.getElementById('result');
    const resultElements = {
        coreFactors: document.getElementById('coreFactors'),
        effectiveVolume: document.getElementById('effectiveVolume'),
        effectiveLength: document.getElementById('effectiveLength'),
        effectiveArea: document.getElementById('effectiveArea'),
        minimumArea: document.getElementById('minimumArea')
    };

    function createFields(coreType) {
        // Clear existing fields
        dynamicFields.innerHTML = '';

        let fieldsHtml = '';

        switch (coreType) {
            case 'EE':
                fieldsHtml = `
                    <h2>EE Core Fields</h2>
                    <div class="form-group">
                        <label for="width">Width:</label>
                        <input type="number" id="width" name="width">
                    </div>
                    <div class="form-group">
                        <label for="height">Height:</label>
                        <input type="number" id="height" name="height">
                    </div>
                    <div class="form-group">
                        <label for="depth">Depth:</label>
                        <input type="number" id="depth" name="depth">
                    </div>
                `;
                break;
            case 'EI':
                fieldsHtml = `
                    <h2>EI Core Fields</h2>
                    <div class="form-group">
                        <label for="width">Width:</label>
                        <input type="number" id="width" name="width">
                    </div>
                    <div class="form-group">
                        <label for="height">Height:</label>
                        <input type="number" id="height" name="height">
                    </div>
                    <div class="form-group">
                        <label for="depth">Depth:</label>
                        <input type="number" id="depth" name="depth">
                    </div>
                `;
                break;
            case 'Toroidal':
                fieldsHtml = `
                    <h2>Toroidal Core Fields</h2>
                    <div class="form-group">
                        <label for="innerDiameter">Inner Diameter:</label>
                        <input type="number" id="innerDiameter" name="innerDiameter">
                    </div>
                    <div class="form-group">
                        <label for="outerDiameter">Outer Diameter:</label>
                        <input type="number" id="outerDiameter" name="outerDiameter">
                    </div>
                    <div class="form-group">
                        <label for="height">Height:</label>
                        <input type="number" id="height" name="height">
                    </div>
                `;
                break;
        }

        dynamicFields.innerHTML = fieldsHtml;

        // Enable the Calculate button if fields are present
        calculateButton.disabled = !fieldsHtml;
    }

    coreTypeSelect.addEventListener('change', function() {
        const coreType = coreTypeSelect.value;
        createFields(coreType);
    });

    document.getElementById('coreForm').addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = new FormData(this);

        // Collect form values
        const data = {
            coreType: formData.get('coreType'),
            width: formData.get('width') || '0',
            height: formData.get('height') || '0',
            depth: formData.get('depth') || '0',
            innerDiameter: formData.get('innerDiameter') || '0',
            outerDiameter: formData.get('outerDiameter') || '0'
        };

        console.log('Collected Data:', data); // Log collected data

        fetch('http://localhost:52000/api/cores/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Response Data:', data); // Log response data
            resultDiv.classList.remove('hidden');
            resultElements.coreFactors.textContent = `Core Factors: ${data['Core Factor']}`;
            resultElements.effectiveVolume.textContent = `Effective Volume: ${data['Effective Volume']}`;
            resultElements.effectiveLength.textContent = `Effective Length: ${data['Effective Length']}`;
            resultElements.effectiveArea.textContent = `Effective Area: ${data['Effective Area']}`;
            resultElements.minimumArea.textContent = `Minimum Area: ${data['Minimum Area']}`;
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });
});
