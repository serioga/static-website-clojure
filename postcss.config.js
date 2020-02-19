module.exports = {
  plugins: [
    require('postcss-import')({path: 'tailwind'}),
    require('tailwindcss')('tailwind/app/config/tailwind.config.js'),
    require('postcss-nested'),
    require('postcss-reporter')
  ]
};
