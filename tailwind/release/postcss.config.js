module.exports = {
  plugins: [
    require('postcss-import')({
      path: 'tailwind'
    }),
    require('tailwindcss')(
      'tailwind/app/config/tailwind.config.js'
    ),
    require('postcss-nested'),
    require('@fullhuman/postcss-purgecss')({
      content: ['release/**/*.html']
    }),
    require('postcss-combine-duplicated-selectors')({
      removeDuplicatedProperties: true
    }),
    require('autoprefixer'),
    require('cssnano')({
      preset: 'default'
    }),
    require('postcss-reporter')
  ]
};
